package de.hsos.prog3.dokranke.ab03;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Ringpuffer<T> implements Deque<T>, RandomAccess, Serializable, Cloneable {

	// Probleme mit add sonst vollständig

	private static final double EXPANSION_FACTOR = 1.5;

	private static class RingpufferIterator<E> implements Iterator<E> {

		Ringpuffer<E> ringpuffer;
		boolean pollFirst;

		public RingpufferIterator(Ringpuffer<E> ringpuffer, boolean pollFirst) {
			this.ringpuffer = (Ringpuffer<E>) ringpuffer.clone();
			this.pollFirst = pollFirst;
		}

		@Override
		public boolean hasNext() {
			return !ringpuffer.isEmpty();
		}

		@Override
		public E next() {
			if (pollFirst) {
				return ringpuffer.pollFirst();
			} else {
				return ringpuffer.pollLast();
			}
		}
	}

	private ArrayList<T> elements;
	private int head;
	private int tail;
	private int size;
	private int capacity;
	private boolean fixedCapacity;
	private boolean discarding;

	public Ringpuffer(int capacity, boolean fixedCapacity, boolean discarding) {
		this.capacity = capacity;
		this.fixedCapacity = fixedCapacity;
		this.discarding = discarding;
		clear();
	}

	private Ringpuffer(Ringpuffer<T> source) {
		capacity = source.capacity;
		fixedCapacity = source.fixedCapacity;
		discarding = source.discarding;

		elements = (ArrayList<T>) source.elements.clone();
		head = source.head;
		tail = source.tail;
		size = source.size;
	}

	private void fill() {
		while (elements.size() < capacity) {
			elements.add(null);
		}
	}

	@Override
	public void addFirst(T t) {
		if (!offerFirst(t)) {
			throw new IllegalStateException();
		}
	}

	@Override
	public void addLast(T t) {
		if (!offerLast(t)) {
			throw new IllegalStateException();
		}
	}

	@Override
	public boolean offerFirst(T t) {
		Objects.requireNonNull(t);

		if (size >= capacity) {
			if (discarding) {
				// Ersetzen
				elements.set(head, t);
				head = (head + 1) % capacity;
				return true;
			} else {
				if (fixedCapacity) {
					// Abbruch
					return false;
				} else {
					// Vergrößern
					int diff = -capacity;
					capacity = (int) (capacity * EXPANSION_FACTOR);
					diff += capacity;
					fill();
					head = (capacity + head - diff) % capacity;
				}
			}
		}

		// Hinzufügen
		elements.set(head, t);
		head = (head + 1) % capacity;
		size++;

		return true;
	}

	@Override
	public boolean offerLast(T t) {
		Objects.requireNonNull(t);

		if (size >= capacity) {
			if (discarding) {
				// Hinzufügen
				elements.add(tail, t);
				// Entfernen
				elements.remove(head + 1);
				head = (head + 1) % capacity;
				return true;
			} else {
				if (fixedCapacity) {
					// Abbruch
					return false;
				} else {
					// Vergrößern
					int diff = -capacity;
					capacity = (int) (capacity * EXPANSION_FACTOR);
					diff += capacity;
					fill();
					head = (capacity + head - diff) % capacity;
				}
			}
		}

		// Hinzufügen
		elements.set(tail, t);
		head = (head + 1) % capacity;
		size++;

		return true;
	}

	@Override
	public T removeFirst() {
		T t = pollFirst();
		if (t != null) {
			return t;
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public T removeLast() {
		T t = pollLast();
		if (t != null) {
			return t;
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public T pollFirst() {
		if (size > 0) {
			T t = peekFirst();
			tail = (tail + 1) % capacity;
			size--;
			return t;
		} else {
			return null;
		}
	}

	@Override
	public T pollLast() {
		if (size > 0) {
			T t = peekLast();
			// Ordnung wieder herstellen??
			tail = (tail + 1) % capacity;
			size--;
			return t;
		} else {
			return null;
		}
	}

	@Override
	public T getFirst() {
		T t = pollFirst();
		if (t != null) {
			return t;
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public T getLast() {
		T t = pollLast();
		if (t != null) {
			return t;
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public T peekFirst() {
		if (size > 0) {
			return elements.get(tail);
		} else {
			return null;
		}
	}

	@Override
	public T peekLast() {
		if (size > 0) {
			return elements.get((size + head - 1) % capacity);
		} else {
			return null;
		}
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		Objects.requireNonNull(o);

		int index = tail;
		while (index != head) {
			if (elements.get(index) == o) {
				elements.set(index, null);
				size--;
				return true;
			}
			index = (index + 1) % capacity;
		}
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		Objects.requireNonNull(o);

		int index = tail;
		while (index != head) {
			if (elements.get(index) == o) {
				elements.set(index, null);
				size--;
				return true;
			}
			index = (size + index - 1) % capacity;
		}
		return false;
	}

	@Override
	public boolean add(T t) {
		if (offer(t)) {
			return true;
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public boolean offer(T t) {
		return offerFirst(t);
	}

	@Override
	public T remove() {
		return removeFirst();
	}

	@Override
	public T poll() {
		return pollFirst();
	}

	@Override
	public T element() {
		return getFirst();
	}

	@Override
	public T peek() {
		return peekFirst();
	}

	@Override
	public void push(T t) {
		addFirst(t);
	}

	@Override
	public T pop() {
		return removeFirst();
	}

	@Override
	public boolean remove(Object o) {
		return removeFirstOccurrence(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		Objects.requireNonNull(c);

		return c.parallelStream().allMatch(o -> contains(o));
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		Objects.requireNonNull(c);

		return c.stream().anyMatch(o -> add(o));
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		Objects.requireNonNull(c);

		return c.stream().anyMatch(o -> remove(o));
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		Objects.requireNonNull(c);

		Collection<?> difference = c.parallelStream().filter(o -> !contains(o)).collect(Collectors.toCollection(ArrayList::new));
		return removeAll(difference);
	}

	@Override
	public void clear() {
		elements = new ArrayList<>();
		fill();

		head = 0;
		tail = 0;
		size = 0;
	}

	@Override
	public boolean contains(Object o) {
		Objects.requireNonNull(o);

		return elements.contains(o);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new RingpufferIterator<>(this, true);
	}

	@Override
	public Iterator<T> descendingIterator() {
		return new RingpufferIterator<>(this, false);
	}

	@Override
	public Object[] toArray() {
		ArrayList list = new ArrayList();
		for (Iterator iter = iterator(); iter.hasNext(); ) {
			list.add(iter.next());
		}
		return list.toArray();
	}

	@Override
	public <E> E[] toArray(E[] a) {
		ArrayList<T> list = new ArrayList<>();
		for (Iterator<T> iter = iterator(); iter.hasNext(); ) {
			list.add(iter.next());
		}
		return list.toArray(a);
	}

	@Override
	protected Object clone() {
		return new Ringpuffer<T>(this);
	}
}

// Domenik Kranke <domenik@kranke.de>
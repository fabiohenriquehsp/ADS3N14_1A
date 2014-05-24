public class Ordena {

	public void insertionSort() {

		int element[] = { 22, 9, 7, 6, 1, 49, 35, 3, 0 };
		int chave;
		int i;
        int comparacao = 0;
		// imprime todos os elementos da lista reordenada
		System.out.println("antes:");
		for (int j = 0; j < element.length; j++) {
			System.out.print(element[j] + " ");
		}
		System.out.println();

		for (int j = 1; j < element.length; j++) {
			chave = element[j];
			i = j - 1;
			while (i >= 0 && element[i] > chave) {
				element[i + 1] = element[i];
				i = i - 1;
				comparacao++;
			}
			element[i + 1] = chave;
		}

		// imprime todos os elementos da lista reordenada
		System.out.println("Depois:");
		for (int j = 0; j < element.length; j++) {
			System.out.print(element[j] + " ");
		}
		System.out.println();
		System.out.println("Comparações: " + comparacao);
		System.out.println();

	}

	static int  count = 0;
	public void Heapsort() {
		int[] numeros = new int[] { 1, 7, 5, 4, 2, 9, 3, 8, 6, 0 };
        
		// Apresenta valores antes de ordenar
		System.out.println("antes:");
		for (int n : numeros) {
			System.out.print(" " + n);
		}
		System.out.println();

		// Ordena os números
		heapSort(numeros);

		// Apresenta valores depois de ordenar
		System.out.println("depois:");
		for (int n : numeros) {
			System.out.print(" " + n);
		}
		System.out.println();
		System.out.println("Comparações: " + count);
		System.out.println();
		System.exit(0);
	}

	public static void heapSort(int v[]) {
		buildMaxHeap(v);
		int n = v.length;

		for (int i = v.length - 1; i > 0; i--) {
			swap(v, i, 0);
			maxHeapify(v, 0, --n);
			count++;
		}
	}

	private static void buildMaxHeap(int v[]) {
		for (int i = v.length / 2 - 1; i >= 0; i--)
			maxHeapify(v, i, v.length);
	}

	private static void maxHeapify(int v[], int pos, int n) {
		int max = 2 * pos + 1, right = max + 1;
		if (max < n) {
			if (right < n && v[max] < v[right])
				max = right;
			if (v[max] > v[pos]) {
				swap(v, max, pos);
				maxHeapify(v, max, n);
			}
		}
	}

	private static void swap(int[] v, int j, int aposJ) {
		int aux = 0;
		aux = v[j];
		v[j] = v[aposJ];
		v[aposJ] = aux;
	}

}

function quickSort(arr: number[]): number[] {
  if (arr.length < 2) return arr

  const pivot = arr[0]
  const tail = arr.slice(1)
  const less = tail.filter((element) => element <= pivot)
  const greater = tail.filter((element) => element > pivot)

  return [...quickSort(less), pivot, ...quickSort(greater)]
}

const array = [5, 3, 6, 2, 6, 10]

console.log(quickSort(array)) // [2, 3, 5, 6, 6, 10]

export {}
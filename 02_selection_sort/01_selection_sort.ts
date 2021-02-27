function selectionSort(array: number[]): number[] {
  const mutableArray = [...array]
  const sortedArray = []

  while (mutableArray.length > 0) {
    const smallest = Math.min(...mutableArray)
    const indexOfSmallest = mutableArray.findIndex(
      (value) => value === smallest
    )
    mutableArray.splice(indexOfSmallest, 1)
    sortedArray.push(smallest)
  }

  return sortedArray
}

const array = [5, 3, 6, 2, 6, 10]

console.log(selectionSort(array)) // [2, 3, 5, 6, 6, 10]

export {}
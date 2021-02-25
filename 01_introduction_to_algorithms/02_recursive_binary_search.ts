function recursiveBinarySearch<T>(sortedList: T[], item: T): number | null {
  const left = 0
  const right = sortedList.length - 1

  function recursion<T>(
    sortedList: T[],
    item: T,
    left: number,
    right: number
  ): number | null {

    if (right >= 1) {
      const mid = Math.floor((left + right) / 2)
      const guess: T = sortedList[mid]

      if (guess === item) return mid
      if (guess > item) return recursion(sortedList, item, left, mid - 1)
      else return recursion(sortedList, item, mid + 1, right)
    }

    return null
  }

  return recursion(sortedList, item, left, right)
}

const list2 = [1, 3, 5, 7, 9, 11, 13, 15]

console.log(recursiveBinarySearch(list2, 3)) // 1
console.log(recursiveBinarySearch(list2, 9)) // 4
console.log(recursiveBinarySearch(list2, -1)) // null

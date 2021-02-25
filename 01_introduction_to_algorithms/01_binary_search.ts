function binarySearch<T>(sortedList: T[], item: T): number | null {
  let left = 0
  let right = sortedList.length - 1

  while (left <= right) {
    const mid = Math.floor((left + right) / 2)
    const guess: T = sortedList[mid]

    if (guess === item) return mid
    if (guess > item) {
      right = mid - 1
    } else {
      left = mid + 1
    }
  }

  return null
}

const list1 = [1, 3, 5, 7, 9, 11, 13, 15]

console.log(binarySearch(list1, 3)) // 1
console.log(binarySearch(list1, 9)) // 4
console.log(binarySearch(list1, -1)) // null

function sum(arr: number[], acc: number = 0): number {
  if (arr.length === 0) return acc

  const lastIndex = arr.length - 1
  const lastElement = arr[lastIndex]

  return sum(arr.slice(0, arr.length - 1), acc + lastElement)
}

const array = [2, 4, 6]

console.log(sum(array))

export {}

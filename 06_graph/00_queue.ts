class Node {
  data: string
  next: Node | null = null

  constructor(data: string) {
    this.data = data
  }
}

class Queue {
  first: Node | null = null
  size = 0

  enqueue(data: string): void {
    const node = new Node(data)

    if (!this.first) {
      this.first = node
    } else {
      let cursor = this.first
      while (cursor.next) {
        cursor = cursor.next
      }
      cursor.next = node
    }

    this.size += 1
  }

  enqueueArray(dataArray: string[]) {
    for (let data of dataArray) {
      if (!this.find(data)) {
        this.enqueue(data)
      }
    }
  }

  find(data: string): boolean {
    let cursor = this.first

    while (cursor) {
      if (cursor.data === data) return true

      cursor = cursor.next
    }

    return false
  }

  dequeue(): Node | null {
    if (this.first) {
      this.size -= 1

      const first = this.first
      this.first = first.next

      return first
    }
    return null
  }

  print(prefix = ''): void {
    let cursor = this.first
    let output = []

    while (cursor) {
      output.push(cursor.data)

      cursor = cursor.next
    }

    if (output.length) console.log(prefix + output.join(' ← '))
  }
}

export { Queue, Node }

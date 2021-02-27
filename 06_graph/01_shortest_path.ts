import { Queue } from './00_queue'

type Graph = {
  [person: string]: string[]
}

const graph: Graph = {
  you: ['claire', 'bob', 'alice'],
  alice: ['peggy'],
  claire: ['tom', 'johnny'],
  bob: ['anuj', 'peggy'],
  tom: [],
  johnny: [],
  peggy: [],
  anuj: [],
}

const queue = new Queue()
queue.enqueueArray(graph.you)

function isMangoSeller(person: string) {
  return person[person.length - 1] === 'm'
}

function findMangoSeller(queue: Queue): boolean {
  while (queue.size) {
    const person = queue.dequeue()
    if (!person) return false

    if (isMangoSeller(person.data)) {
      console.log(person.data + ' is a mango seller')
      return true
    } else {
      queue.enqueueArray(graph[person.data])
    }
  }

  console.log('No mango sellers found.');

  return false
}

findMangoSeller(queue)

export {}

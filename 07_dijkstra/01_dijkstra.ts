type Vertex = 'book' | 'plate' | 'poster' | 'drum' | 'guitar' | 'piano'

type Dir = {
  vertex: Vertex
  price: number
}

type Graph = {
  [vertex in Vertex]: Dir[]
}

type PriceTable = {
  [vertex in Vertex]: number
}

const graph: Graph = {
  book: [
    { vertex: 'poster', price: 0 },
    { vertex: 'plate', price: 5 },
  ],
  plate: [
    { vertex: 'guitar', price: 15 },
    { vertex: 'drum', price: 20 },
  ],
  poster: [
    { vertex: 'guitar', price: 20 },
    { vertex: 'drum', price: 35 },
  ],
  drum: [{ vertex: 'piano', price: 10 }],
  guitar: [{ vertex: 'piano', price: 20 }],
  piano: [],
}

function findShortestPath(graph: Graph, start: Vertex, end: Vertex): number {
  const prices = Object.fromEntries(
    Object.keys(graph).map((key) =>
      key === start ? [key, 0] : [key, Infinity]
    )
  ) as PriceTable

  for (let vertex of Object.keys(graph) as Array<Vertex>) {
    for (let dir of graph[vertex]) {
      const guess = prices[vertex] + dir.price
      if (prices[dir.vertex] === Infinity || guess < prices[dir.vertex]) {
        prices[dir.vertex] = guess
      }
    }
  }

  return prices[end]
}

console.log(findShortestPath(graph, 'book', 'piano'))

export {}

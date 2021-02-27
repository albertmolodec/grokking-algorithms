type Vertex = 'book' | 'plate' | 'poster' | 'drum' | 'guitar' | 'piano'

type Edge = {
  to: Vertex
  weight: number
}

type Graph = {
  [vertex in Vertex]: Edge[]
}

type PriceTable = {
  [to in Vertex]: number
}

const graph: Graph = {
  book: [
    { to: 'poster', weight: 0 },
    { to: 'plate', weight: 5 },
  ],
  plate: [
    { to: 'guitar', weight: 15 },
    { to: 'drum', weight: 20 },
  ],
  poster: [
    { to: 'guitar', weight: 20 },
    { to: 'drum', weight: 35 },
  ],
  drum: [{ to: 'piano', weight: 10 }],
  guitar: [{ to: 'piano', weight: 20 }],
  piano: [],
}

function findShortestPath(graph: Graph, start: Vertex, end: Vertex): number {
  const prices = Object.fromEntries(
    Object.keys(graph).map((key) =>
      key === start ? [key, 0] : [key, Infinity]
    )
  ) as PriceTable

  for (let vertex of Object.keys(graph) as Array<Vertex>) {
    for (let edge of graph[vertex]) {
      const guess = prices[vertex] + edge.weight
      if (prices[edge.to] === Infinity || guess < prices[edge.to]) {
        prices[edge.to] = guess
      }
    }
  }

  return prices[end]
}

console.log(findShortestPath(graph, 'book', 'piano'))

export {}

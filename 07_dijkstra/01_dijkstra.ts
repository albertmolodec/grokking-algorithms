type Vertex = 'book' | 'plate' | 'poster' | 'drum' | 'guitar' | 'piano'

type Edge = {
  to: Vertex
  weight: number
}

type Graph = {
  [vertex in Vertex]: Edge[]
}

type TableRow = {
  from?: Vertex
  weight: number
}

type Table = {
  [to in Vertex]: TableRow
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

function findShortestPath(
  graph: Graph,
  start: Vertex,
  end: Vertex
): { price: number; path: string[] } {
  // Create table
  const table = Object.fromEntries(
    Object.keys(graph).map((key) =>
      key === start ? [key, { weight: 0 }] : [key, { weight: Infinity }]
    )
  ) as Table

  // Fill table
  for (let vertex of Object.keys(graph) as Array<Vertex>) {
    for (let edge of graph[vertex]) {
      const guess = table[vertex].weight + edge.weight
      if (table[edge.to].weight === Infinity || guess < table[edge.to].weight) {
        table[edge.to].weight = guess
        table[edge.to].from = vertex
      }
    }
  }

  // Get path from table
  const reversedPath: string[] = []
  let cursor = end

  while (cursor !== start) {
    cursor = table[cursor].from!

    if (cursor !== start) reversedPath.push(cursor)
  }

  return { price: table[end].weight, path: reversedPath.reverse() }
}

const start = 'book'
const end = 'piano'
const { price, path } = findShortestPath(graph, start, end)

console.log(`Price: ${price}$.\nPath: ${start} → ${path.join(' → ')} → ${end}.`)

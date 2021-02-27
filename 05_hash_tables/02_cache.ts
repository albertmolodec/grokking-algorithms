type Data = string

type MyCache = {
  [url: string]: Data
}

const cache: MyCache = {}

function getDataFromServer(url: string): Data {
  return `some data from url ${url}`
}

function getPage(url: string): Data {
  if (cache[url] !== undefined) {
    console.info('Using cached data', url)
    return cache[url]
  }

  const data = getDataFromServer(url)
  cache[url] = data
  return data
}

console.log(getPage('https://vk.com/'))
console.log(getPage('https://vk.com/about/'))
console.log(getPage('https://vk.com/'))

export {}

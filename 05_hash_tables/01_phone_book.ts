type PhoneBook = {
  [key: string]: number
}

const phoneBook: PhoneBook = {}

phoneBook['jenny'] = 8675309
phoneBook['emergency'] = 911

console.log(phoneBook.jenny)

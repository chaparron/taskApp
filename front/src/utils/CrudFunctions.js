export const crudDelete = async (id) => {
    const url = 'http://localhost:8080/api/tasks/delete/' + id
    await fetch(url, {
      method: 'DELETE',
      headers: { 'Content-Type': 'application/json' }
    })
  }

  export const crudAdd = async (task) => {
    const url = 'http://localhost:8080/api/tasks'
    await fetch(url, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(task)
    })
  }

  export const crudEdit = async (task) => {
    crudAdd(task)
  }

  export const crudGetAll = async () => {
    const url = 'http://localhost:8080/api/tasks'
    const response = await fetch(url, {
      method: 'GET',
      headers: { 'Content-Type': 'application/json' }
    })
    const responseJson = await response.json()
    return responseJson
  }

  export const crudGetOne = async (id) => {
    const url = 'http://localhost:8080/api/tasks/' + id
    const response = await fetch(url, {
      method: 'GET',
      headers: { 'Content-Type': 'application/json' }
    })
    const responseJson = await response.json()
    return responseJson
  }

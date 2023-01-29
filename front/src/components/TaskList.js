import { useEffect, useState } from 'react';
import {Link} from 'react-router-dom'
import { crudGetAll, crudDelete } from '../utils/CrudFunctions'

const TaskList = () => {
    const [tasks, setTasks] = useState()
  
    const getTasks = async () => {
      const responseJson = await crudGetAll()
      setTasks(responseJson)
    }
  
    const deleteTask = async (id) => {
      await crudDelete(id)
      getTasks()
    }
  
    useEffect(() => {
      getTasks()
    }, [])

    return (
        <div className="flex justify-center">
          <div className='w-6/12'>
            {!tasks ? 'Loading...' :
              tasks.map(task => {
                return (<div className='bg-gray-900 py-5 px-20 text-white shadow-2x1 mb-4 flex justify-between' key={task.id}>
                  <div>
                    <h1>Title: {task.title}</h1>
                    <h6>Id: {task.id}</h6>
                    <p>Desc: {task.description}</p>
                    <button
                      className='bg-purple-600 hover:bg-purple-500 py-1 px-3 mt-2'>
                      {task.done ? 'Done' : "Undone"}
                    </button>
                  </div>
                  <div>
                  <Link 
                  to={`/edit/${task.id}`}
                  className='bg-gray-600 hover:bg-gray-500 py-2 px-4 my-4'>
                    Edit
                  </Link>
                  <button 
                  className='bg-red-600 hover:bg-red-500 py-2 px-4 my-4'
                  onClick = { () => deleteTask( task.id ) }>
                    Delete
                    </button>
                </div>
                </div>)
              })
            }
          </div>
        </div>
      );
}

export default TaskList
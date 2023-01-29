
import './App.css';
import { Route, Routes } from 'react-router-dom'
import TaskList from './components/TaskList'
import Heading from './components/Heading'
import TaskForm from './components/TaskForm'

function App() {
  return (
    <div>
      <div className="h-screen text-white text-center p-10">
        <div className="container mx-auto h-full">
          <Heading />
          <Routes>
            <Route path='/' element={<TaskList />} exact />
            <Route path='/add' element={<TaskForm />} />
            <Route path='/edit/:id' element={<TaskForm />} />
          </Routes>
        </div>
      </div>
    </div>
  );
}

export default App;
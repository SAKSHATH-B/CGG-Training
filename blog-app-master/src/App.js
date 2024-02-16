import logo from './logo.svg';
import './App.css';
import { Home } from './components/Pages/Home';
import { About } from './components/Pages/About';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Login } from './components/Pages/Login';
import { Signup } from './components/Pages/Signup';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Services } from './components/Services';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { User } from './components/User';
import { Dashboard } from './components/Pages/user-module/Dashboard';
import { ProfileInfo } from './components/Pages/user-module/ProfileInfo';
function App() {
  return (
   
     <BrowserRouter>
       <ToastContainer position='bottom-center'/>
      <Routes>
         <Route path="/" element={<Home/>}/>
         <Route path="/about" element={<About/>}/>
         <Route path="/login" element={<Login/>}/>
         <Route path="/signup" element={<Signup/>}/>
         <Route path="/services" element={<Services/>}/>
         <Route path="/user" element={<User/>}>
            <Route path='dashboard' element={<Dashboard/>}/>
            <Route path='profile-info' element={<ProfileInfo/>}/>
           
         </Route>
      </Routes>
     
     </BrowserRouter>
  );
}

export default App;

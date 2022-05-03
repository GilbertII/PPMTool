import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import Header from "./components/layout/Header";
import Dashboard from "./components/Dashboard";
import AddProject from "./components/project/AddProject";

import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Routes>
          <Route exact path="/" element={<Dashboard />} />
          <Route exact path="/dashboard" element={<Dashboard />} />
          <Route exact path="/addProject" element={<AddProject />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;

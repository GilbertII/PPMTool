import { Link } from "react-router-dom";

function CreateProjectButton() {
  return (
    <div>
      <Link to="/addProject" href="ProjectForm.html" className="btn btn-lg btn-info">
        Create a Project
      </Link>
    </div>
  );
}

export default CreateProjectButton;

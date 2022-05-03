import CreateProjectButton from "./project/CreateProjectButton";
import ProjectItem from "./project/ProjectItem";

function Dashboard() {
  return (
    <div className="projects">
      <div className="container">
        <div className="row">
          <div className="col-md-12">
            <h1 className="display-4 text-center">Projects</h1>
            <br />
            <CreateProjectButton />
            <br />
            <hr />
            {/* Project Item Here */}
            <ProjectItem />
            <ProjectItem />
            <ProjectItem />
          </div>
        </div>
      </div>
    </div>
  );
}

export default Dashboard;

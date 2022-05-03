import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faFlag, faEdit, faRemove } from "@fortawesome/free-solid-svg-icons";

function ProjectItem() {
  return (
    <div className="container">
      <div className="card card-body bg-light mb-3">
        <div className="row">
          <div className="col-2">
            <span className="mx-auto">REACT</span>
          </div>
          <div className="col-lg-6 col-md-4 col-8">
            <h3>Spring / React Project</h3>
            <p>Project to create a Kanban Board with Spring Boot and React</p>
          </div>
          <div className="col-md-4 d-none d-lg-block">
            <ul className="list-group">
              <a href="#">
                <li className="list-group-item board">
                  <FontAwesomeIcon icon={faFlag} className="text-info" />
                  <span style={{ padding: 5 }}>Project Board</span>
                </li>
              </a>
              <a href="#">
                <li className="list-group-item update">
                  <FontAwesomeIcon icon={faEdit} className="text-primary" />
                  <span style={{ padding: 5 }}>Update Project Info</span>
                </li>
              </a>
              <a href="">
                <li className="list-group-item delete">
                  <FontAwesomeIcon icon={faRemove} className="text-danger" />
                  <span style={{ padding: 5 }}>Delete Project</span>
                </li>
              </a>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ProjectItem;

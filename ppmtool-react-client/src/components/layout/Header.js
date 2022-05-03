import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSignIn, faLock, faDashboard } from "@fortawesome/free-solid-svg-icons";

function Header() {
  return (
    <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
      <div className="container">
        <a className="navbar-brand" href="Dashboard.html">
          Personal Project Management Tool
        </a>
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#mobile-nav"
        >
          <span className="navbar-toggler-icon" />
        </button>

        <div className="collapse navbar-collapse" id="mobile-nav">
          <ul className="navbar-nav me-auto">
            <li className="nav-item">
              <a className="nav-link" href="/dashboard">
                <span>
                  <FontAwesomeIcon icon={faDashboard} size="lg" /> Dashboard
                </span>
              </a>
            </li>
          </ul>

          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <a className="nav-link " href="register.html">
                <span>
                  <FontAwesomeIcon icon={faSignIn} size="lg" /> Sign Up
                </span>
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="login.html">
                <span>
                  <FontAwesomeIcon icon={faLock} size="lg" /> Login
                </span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Header;

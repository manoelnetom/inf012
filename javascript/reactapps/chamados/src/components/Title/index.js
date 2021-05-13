
import './title.css'

function Title({children, nome}) {

    return (
      <div className="title">
        {children}
        <span>{nome}</span>
      </div>
    );
  }
  
  export default Title;
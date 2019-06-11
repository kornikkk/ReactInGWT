import React from "react";
import styles from "./Tree.module.css";

class Tree extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <ul className={styles.Tree}>
                {this.props.children}
            </ul>
        );
    }
}

export default Tree;
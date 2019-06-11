import React from "react";
import styles from "./Tree.module.css";

class TreeElement extends React.Component {
    constructor(props) {
        super(props);
        this.state = {expanded: props.expanded !== undefined ? props.expanded : false};
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
        this.setState(state => ({
            expanded: !state.expanded
        }));
    }

    render() {
        const caretEnabledClassName = this.props.children === undefined ? styles.disabled : styles.enabled;
        const nodeExpandedClassName = this.state.expanded ? styles.expanded : styles.collapsed;
        return (
            <li>
                <span className={`${styles.TreeElement} ${styles.node}`}>
                    <span className={`${styles.TreeElement} ${styles.caret} ${caretEnabledClassName} ${nodeExpandedClassName}`}
                          onClick={this.handleClick}>
                    </span>
                    {this.props.name}
                </span>
                <ul className={`${styles.TreeElement} ${styles.children} ${nodeExpandedClassName}`}>
                    {this.props.children}
                </ul>
            </li>
        );
    }
}

export default TreeElement;
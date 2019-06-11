import React from "react";
import TreeElement from "./tree/TreeElement";
import Tree from "./tree/Tree";

class TreeView extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {

        return (
            <Tree>
                <TreeElement name="Test">
                    <TreeElement name="Test child">
                        <TreeElement name="Test child 0.1"/>
                        <TreeElement name="Test child 0.2"/>
                    </TreeElement>
                    <TreeElement name="Test child 2"/>
                </TreeElement>
                <TreeElement name="Test 2"/>
            </Tree>
        );
    }
}

//
// const data = {
//     name: "root",
//     toggled: true,
//     children: [
//         {
//             name: "parent",
//             children: [{name: "child1"}, {name: "child2"}]
//         },
//         {
//             name: "loading parent",
//             loading: true,
//             children: []
//         },
//         {
//             name: "parent",
//             children: [
//                 {
//                     name: "nested parent",
//                     children: [{name: "nested child 1"}, {name: "nested child 2"}]
//                 }
//             ]
//         }
//     ]
// };

export default TreeView;
"use strict";
var NodeOfTree = /** @class */ (function () {
    function NodeOfTree(value, key) {
        this._value = value;
        this.right = null;
        this.left = null;
        this._key = key;
    }
    Object.defineProperty(NodeOfTree.prototype, "key", {
        get: function () {
            return this._key;
        },
        enumerable: false,
        configurable: true
    });
    NodeOfTree.prototype.addLeft = function (value, key) {
        this.left = new NodeOfTree(value, key);
    };
    NodeOfTree.prototype.addRight = function (value, key) {
        this.right = new NodeOfTree(value, key);
    };
    NodeOfTree.prototype.setLeft = function (left) {
        this.left = left;
    };
    NodeOfTree.prototype.setRight = function (right) {
        this.right = right;
    };
    Object.defineProperty(NodeOfTree.prototype, "value", {
        get: function () {
            return this._value;
        },
        enumerable: false,
        configurable: true
    });
    return NodeOfTree;
}());
var BinaryTree = /** @class */ (function () {
    function BinaryTree() {
        this.treeHead = null;
    }
    BinaryTree.prototype.empty = function () {
        return (this.treeHead === null);
    };
    BinaryTree.prototype.add = function (value, key) {
        if (this.treeHead != null) {
            var step = this.treeHead;
            while (step != null) {
                if (step.key < key) {
                    if (step.right == null) {
                        step.right = new NodeOfTree(value, key);
                        break;
                    }
                    step = step.right;
                }
                else if (step.key > key) {
                    if (step.left == null) {
                        step.left = new NodeOfTree(value, key);
                        break;
                    }
                    step = step.left;
                }
                else {
                    console.log("Ошибка");
                }
            }
        }
        else {
            this.treeHead = new NodeOfTree(value, key);
        }
    };
    BinaryTree.prototype.parent = function (nextKey) {
        var step = this.treeHead;
        var prevStep = null;
        while (step !== null) {
            if (step.key === nextKey) {
                return prevStep;
            }
            prevStep = step;
            step = (step.key < nextKey) ? step.right : step.left;
            /*if (step.key < nextKey) {
                step = step.right;
            } else {
                step = step.left;
            }*/
        }
        return null;
    };
    BinaryTree.prototype.find = function (key) {
        var step = this.treeHead;
        while (step !== null) {
            if (step.key === key) {
                return step;
            }
            step = (step.key < key) ? step.right : step.left;
            /*if (step.key < key) {
                step = step.right
            }
            else {
                step = step.left
            }*/
        }
        return step;
    };
    BinaryTree.prototype.delete = function (key) {
        if (this.empty()) {
            console.log("There is nothing in the tree");
            return;
        }
        // let
        var parentNode = this.parent(key);
        // let
        var delNode = this.find(key);
        if (((delNode === null || delNode === void 0 ? void 0 : delNode.left) == null) && ((delNode === null || delNode === void 0 ? void 0 : delNode.right) == null)) {
            if (parentNode == null) {
                this.treeHead = null;
            }
            else if ((parentNode === null || parentNode === void 0 ? void 0 : parentNode.left) === delNode) {
                parentNode.setLeft(null);
            }
            else {
                parentNode.setRight(null);
            }
        }
        else if (((delNode === null || delNode === void 0 ? void 0 : delNode.left) == null) || ((delNode === null || delNode === void 0 ? void 0 : delNode.right) == null)) {
            if ((delNode === null || delNode === void 0 ? void 0 : delNode.left) == null) {
                if (parentNode == null) {
                    this.treeHead = delNode.right;
                }
                else if ((parentNode === null || parentNode === void 0 ? void 0 : parentNode.left) === delNode) {
                    parentNode.setLeft(delNode === null || delNode === void 0 ? void 0 : delNode.right);
                }
                else {
                    parentNode.setRight(delNode === null || delNode === void 0 ? void 0 : delNode.right);
                }
            }
            else {
                if (parentNode == null) {
                    this.treeHead = delNode.left;
                }
                else if ((parentNode === null || parentNode === void 0 ? void 0 : parentNode.left) === delNode) {
                    parentNode.setLeft(delNode === null || delNode === void 0 ? void 0 : delNode.left);
                }
                else {
                    parentNode.setRight(delNode === null || delNode === void 0 ? void 0 : delNode.left);
                }
            }
        }
        else {
            var replaceNode = delNode.right;
            var parentReplaceNode = delNode;
            while (replaceNode.left != null) {
                parentReplaceNode = replaceNode;
                replaceNode = replaceNode === null || replaceNode === void 0 ? void 0 : replaceNode.left;
            }
            if (replaceNode.right != null) {
                if (parentReplaceNode === delNode) {
                    parentReplaceNode.right = replaceNode.right;
                }
                else {
                    parentReplaceNode.left = replaceNode.right;
                }
            }
            else {
                if (parentReplaceNode === delNode) {
                    parentReplaceNode.right = null;
                }
                else {
                    parentReplaceNode.left = null;
                }
            }
            if (parentNode != null) {
                if ((parentNode === null || parentNode === void 0 ? void 0 : parentNode.left) === delNode) {
                    parentNode.setLeft(replaceNode);
                }
                else {
                    parentNode.setRight(replaceNode);
                }
            }
            if (delNode.left !== replaceNode) {
                replaceNode.setLeft(delNode.left);
            }
            if (delNode.right !== replaceNode) {
                replaceNode.setRight(delNode.right);
            }
            if (parentNode == null) {
                this.treeHead = replaceNode;
            }
        }
    };
    BinaryTree.prototype.print = function (curNode) {
        if (curNode === void 0) { curNode = this.treeHead; }
        if (this.treeHead == null) {
            console.log("There is nothing in the tree");
            return;
        }
        if (curNode != null) {
            console.log(curNode.value);
            this.print(curNode === null || curNode === void 0 ? void 0 : curNode.left);
            this.print(curNode === null || curNode === void 0 ? void 0 : curNode.right);
        }
    };
    return BinaryTree;
}());
var tree = new BinaryTree();
var exitFlag = 0;
tree.add(3, 3);
tree.add(1, 1);
tree.add(4, 4);
tree.add(0, 0);
tree.add(2, 2);
tree.add(6, 6);
tree.add(5, 5);
tree.add(7, 7);
tree.print();
console.log("dasdas");
tree.delete(3);
tree.delete(1);
tree.delete(4);
tree.delete(0);
tree.delete(2);
tree.delete(6);
tree.delete(5);
console.log("aaaaaa");
tree.print();
tree.add(1, 1);
console.log("bbbbbbb");
tree.print();
tree.delete(7);
console.log("bvvbbxbxcb");
tree.print();
console.log(tree.find(2) == null);

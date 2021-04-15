"use strict";
var _a, _b, _c, _d;
var NodeOfTree = /** @class */ (function () {
    function NodeOfTree(value, key, div, atributeClass) {
        this._value = value;
        this.right = null;
        this.left = null;
        this._key = key;
        this.div = document.createElement("div");
        this.div.setAttribute("class", atributeClass);
        if (typeof this._value === "number") {
            this.div.innerHTML = "<p class = 'nodeTree'>" + this._value.toString() + "<sub>" + this._key.toString() + "</sub>" + "</p>";
        }
        else if (typeof this._value === "string") {
            this.div.innerHTML = this._value;
        }
        else {
            this.div.innerHTML = "?????????";
        }
        div.appendChild(this.div);
    }
    Object.defineProperty(NodeOfTree.prototype, "key", {
        get: function () {
            return this._key;
        },
        enumerable: false,
        configurable: true
    });
    NodeOfTree.prototype.addLeft = function (value, key) {
        this.left = new NodeOfTree(value, key, this.div, "nodeLeft");
    };
    NodeOfTree.prototype.addRight = function (value, key) {
        this.right = new NodeOfTree(value, key, this.div, "nodeRight");
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
    NodeOfTree.prototype.setColor = function (color) {
        if (color === void 0) { color = 0; }
        if (color === 0) {
            this.div.style.color = "black";
        }
        else if (color === 1) {
            this.div.style.color = "red";
        }
        else if (color === 2) {
            this.div.style.color = "green";
        }
        else if (color === 3) {
            this.div.style.color = "blue";
        }
        else if (color === 4) {
            this.div.style.color = "yellow";
        }
    };
    return NodeOfTree;
}());
var BinaryTree = /** @class */ (function () {
    function BinaryTree() {
        this.height = 6;
        this.treeHead = null;
        this.div = null;
    }
    BinaryTree.prototype.empty = function () {
        return (this.treeHead === null);
    };
    BinaryTree.prototype.clearColorNode = function (curNode) {
        if (curNode === void 0) { curNode = this.treeHead; }
        if (this.treeHead == null) {
            return;
        }
        if (curNode != null) {
            curNode.setColor(0);
            this.clearColorNode(curNode === null || curNode === void 0 ? void 0 : curNode.left);
            this.clearColorNode(curNode === null || curNode === void 0 ? void 0 : curNode.right);
        }
    };
    BinaryTree.prototype.add = function (key, value, htmlElem) {
        if (this.treeHead != null) {
            this.clearColorNode();
            var step = this.treeHead;
            var cur_height = 1;
            while (step != null) {
                // step.setColor(2);
                setTimeout(setColor, 1000, step, 2);
                cur_height += 1;
                if (cur_height > this.height) {
                    alert("Вы превысили максимум");
                    return;
                }
                if (step.key < key) {
                    if (step.right == null) {
                        step.right = new NodeOfTree(value, key, step.div, "nodeRight");
                        setTimeout(setColor, 1000, step.right, 4);
                        break;
                    }
                    step = step.right;
                }
                else if (step.key > key) {
                    if (step.left == null) {
                        step.left = new NodeOfTree(value, key, step.div, "nodeLeft");
                        setTimeout(setColor, 1000, step.left, 4);
                        break;
                    }
                    step = step.left;
                }
                else {
                    alert("Такой ключ уже есть!");
                    return;
                }
            }
        }
        else {
            if (htmlElem !== undefined) {
                this.div = htmlElem;
            }
            if (this.div !== null) {
                this.treeHead = new NodeOfTree(value, key, this.div, "treeBody");
            }
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
        }
        return null;
    };
    BinaryTree.prototype.find = function (key, color) {
        if (color === void 0) { color = 0; }
        this.clearColorNode();
        var step = this.treeHead;
        while (step !== null) {
            if (color !== 0) {
                setTimeout(setColor, 1000, step, color);
            }
            if (step.key === key) {
                if (color !== 0) {
                    setTimeout(setColor, 1000, step, 4);
                }
                return step;
            }
            step = (step.key < key) ? step.right : step.left;
        }
        return step;
    };
    BinaryTree.prototype.delete = function (key) {
        var _a, _b, _c, _d, _e, _f;
        if (this.empty()) {
            console.log("There is nothing in the tree");
            return;
        }
        var parentNode = this.parent(key);
        var delNode = this.find(key, 1);
        if (delNode === null) {
            alert("Элемента с таким ключом нет!");
            return;
        }
        if (((delNode === null || delNode === void 0 ? void 0 : delNode.left) == null) && ((delNode === null || delNode === void 0 ? void 0 : delNode.right) == null)) {
            if (parentNode == null) {
                (_a = this.treeHead) === null || _a === void 0 ? void 0 : _a.div.remove();
                this.treeHead = null;
            }
            else if ((parentNode === null || parentNode === void 0 ? void 0 : parentNode.left) === delNode) {
                delNode === null || delNode === void 0 ? void 0 : delNode.div.remove();
                parentNode.setLeft(null);
            }
            else {
                delNode === null || delNode === void 0 ? void 0 : delNode.div.remove();
                parentNode.setRight(null);
            }
        }
        else if (((delNode === null || delNode === void 0 ? void 0 : delNode.left) == null) || ((delNode === null || delNode === void 0 ? void 0 : delNode.right) == null)) {
            if ((delNode === null || delNode === void 0 ? void 0 : delNode.left) == null) {
                if (parentNode == null) {
                    if (delNode.right !== null) {
                        delNode.right.div.className = "treeBody";
                        (_b = this.div) === null || _b === void 0 ? void 0 : _b.append(delNode.right.div);
                    }
                    this.treeHead = delNode.right;
                }
                else if ((parentNode === null || parentNode === void 0 ? void 0 : parentNode.left) === delNode) {
                    parentNode.setLeft(delNode === null || delNode === void 0 ? void 0 : delNode.right);
                    if (delNode.right !== null) {
                        delNode.right.div.className = "nodeLeft";
                        parentNode.div.append(delNode.right.div);
                    }
                }
                else {
                    parentNode.setRight(delNode === null || delNode === void 0 ? void 0 : delNode.right);
                    if (delNode.right !== null) {
                        parentNode.div.append(delNode.right.div);
                    }
                }
            }
            else {
                if (parentNode == null) {
                    if (delNode.left !== null) {
                        delNode.left.div.className = "treeBody";
                        (_c = this.div) === null || _c === void 0 ? void 0 : _c.append(delNode.left.div);
                    }
                    this.treeHead = delNode.left;
                }
                else if ((parentNode === null || parentNode === void 0 ? void 0 : parentNode.left) === delNode) {
                    parentNode.setLeft(delNode === null || delNode === void 0 ? void 0 : delNode.left);
                    if (delNode.left !== null) {
                        parentNode.div.append(delNode.left.div);
                    }
                }
                else {
                    parentNode.setRight(delNode === null || delNode === void 0 ? void 0 : delNode.left);
                    if (delNode.left !== null) {
                        delNode.left.div.className = "nodeRight";
                        parentNode.div.append(delNode.left.div);
                    }
                }
            }
            delNode.div.remove();
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
                    parentReplaceNode.div.append(replaceNode.right.div);
                    parentReplaceNode.right = replaceNode.right;
                }
                else {
                    replaceNode.right.div.className = "nodeLeft";
                    parentReplaceNode.div.append(replaceNode.right.div);
                    parentReplaceNode.left = replaceNode.right;
                }
            }
            else {
                if (parentReplaceNode === delNode) {
                    (_d = parentReplaceNode.right) === null || _d === void 0 ? void 0 : _d.div.remove();
                    parentReplaceNode.right = null;
                    delNode.div.remove();
                }
                else {
                    (_e = parentReplaceNode.left) === null || _e === void 0 ? void 0 : _e.div.remove();
                    parentReplaceNode.left = null;
                    delNode.div.remove();
                }
            }
            if (parentNode != null) {
                if ((parentNode === null || parentNode === void 0 ? void 0 : parentNode.left) === delNode) {
                    replaceNode.div.className = "nodeLeft";
                    parentNode.div.append(replaceNode.div);
                    parentNode.setLeft(replaceNode);
                }
                else {
                    replaceNode.div.className = "nodeRight";
                    parentNode.div.append(replaceNode.div);
                    parentNode.setRight(replaceNode);
                }
            }
            if (delNode.left !== replaceNode) {
                replaceNode.div.append(delNode.left.div);
                replaceNode.setLeft(delNode.left);
            }
            if (delNode.right !== replaceNode) {
                replaceNode.div.append(delNode.right.div);
                replaceNode.setRight(delNode.right);
            }
            if (parentNode == null) {
                replaceNode.div.className = "treeBody";
                (_f = this.div) === null || _f === void 0 ? void 0 : _f.append(replaceNode.div);
                this.treeHead = replaceNode;
            }
            delNode.div.remove();
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
function setColor(node, color) {
    node === null || node === void 0 ? void 0 : node.setColor(color);
}
var resultFind = document.createElement("div");
resultFind.className = "resultFind";
(_a = document.getElementById("findCoeff")) === null || _a === void 0 ? void 0 : _a.append(resultFind);
var tree = new BinaryTree();
tree.div = document.getElementById("treeBody");
function pressInpBut() {
    resultFind.innerHTML = "";
    var key = null;
    var val = null;
    var tmp = document.getElementById("inpKey").value;
    if (typeof tmp === "string") {
        if (tmp !== "") {
            key = +tmp;
        }
    }
    tmp = document.getElementById("inpVal").value;
    if (typeof tmp === "string") {
        if (tmp !== "") {
            val = +tmp;
        }
    }
    if ((val !== null) && (key !== null)) {
        tree.add(key, val);
    }
}
function pressDelBut() {
    resultFind.innerHTML = "";
    var key = null;
    var tmp = document.getElementById("delKey").value;
    if (typeof tmp === "string") {
        if (tmp !== "") {
            key = +tmp;
        }
    }
    if (key !== null) {
        tree.delete(key);
    }
}
function pressFindBut() {
    var _a;
    var key = null;
    var tmp = document.getElementById("findKey").value;
    if (typeof tmp === "string") {
        if (tmp !== "") {
            key = +tmp;
        }
    }
    if (key !== null) {
        var res = (_a = tree.find(key, 3)) === null || _a === void 0 ? void 0 : _a.value;
        var resString = "";
        if (typeof res === "number") {
            resString = "Значение при заданном ключе: " + res;
        }
        else if ((typeof res === null) || (res === undefined)) {
            resString = "Ваше значение при заданном ключе не найдено";
        }
        resultFind.innerHTML = resString;
    }
}
(_b = document.getElementById("inpButton")) === null || _b === void 0 ? void 0 : _b.setAttribute("onclick", "pressInpBut()");
(_c = document.getElementById("delButton")) === null || _c === void 0 ? void 0 : _c.setAttribute("onclick", "pressDelBut()");
(_d = document.getElementById("findButton")) === null || _d === void 0 ? void 0 : _d.setAttribute("onclick", "pressFindBut()");

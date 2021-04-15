class NodeOfTree<T> {
    public right: NodeOfTree<T> | null;
    public left: NodeOfTree<T> | null;
    private _value: T;
    private _key: number;
    public div: HTMLElement;
    public constructor(value: T, key: number, div: HTMLElement, atributeClass: string) {
        this._value = value;
        this.right = null;
        this.left = null;
        this._key = key;
        this.div = document.createElement("div");
        this.div.setAttribute("class", atributeClass);
        if (typeof this._value === "number") {
            this.div.innerHTML = "<p class = 'nodeTree'>" + this._value.toString() + "<sub>" + this._key.toString() + "</sub>" + "</p>";
        } else if (typeof this._value === "string") {
            this.div.innerHTML = this._value;
        } else {
            this.div.innerHTML = "?????????";
        }
        div.appendChild(this.div);
    }

    public get key(): number {
        return this._key;
    }

    public addLeft(value: T, key: number): void {
        this.left = new NodeOfTree(value, key, this.div, "nodeLeft");
    }
    public addRight(value: T, key: number): void {
        this.right = new NodeOfTree(value, key, this.div, "nodeRight");
    }

    public setLeft(left: NodeOfBTree<T>): void {
        this.left = left;
    }

    public setRight(right: NodeOfBTree<T>): void {
        this.right = right;
    }

    public get value(): T {
        return this._value;
    }

    public setColor(color: number = 0): void {
        if (color === 0) {
            this.div.style.color = "black";
        } else if (color === 1) {
            this.div.style.color = "red";
        } else if (color === 2) {
            this.div.style.color = "green";
        } else if (color === 3) {
            this.div.style.color = "blue";
        } else if (color === 4) {
            this.div.style.color = "yellow";
        }
    }
}

type NodeOfBTree<T> = NodeOfTree<T> | null;

class BinaryTree<T> {
    private treeHead: NodeOfBTree<T>;
    private height: number = 6;
    public div: HTMLElement | null;

    public constructor() {
        this.treeHead = null;
        this.div = null;
    }

    public empty(): boolean {
        return (this.treeHead === null);
    }

    private clearColorNode(curNode: NodeOfBTree<T> = this.treeHead): void {
        if (this.treeHead == null) {
            return;
        }
        if (curNode != null) {
            curNode.setColor(0);
            this.clearColorNode(curNode?.left);
            this.clearColorNode(curNode?.right);
        }
    }

    public add(key: number, value: T, htmlElem?: HTMLElement): void {
        if (this.treeHead != null) {
            this.clearColorNode();
            let step: NodeOfBTree<T>  = this.treeHead;
            let cur_height: number = 1;
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
                } else if (step.key > key) {
                    if (step.left == null) {
                        step.left = new NodeOfTree(value, key, step.div, "nodeLeft");
                        setTimeout(setColor, 1000, step.left, 4);
                        break;
                    }
                    step = step.left;
                } else {
                    alert("Такой ключ уже есть!");
                    return;
                }
            }
        } else {
            if (htmlElem !== undefined) {
              this.div = htmlElem;
            }
            if (this.div !== null) {
                this.treeHead = new NodeOfTree(value, key, this.div, "treeBody");
            }
        }
    }

    public parent(nextKey: number): NodeOfBTree<T> {
        let step: NodeOfBTree<T>  = this.treeHead;
        let prevStep: NodeOfBTree<T> = null;
        while (step !== null) {
            if (step.key === nextKey) {
                return prevStep;
            }
            prevStep = step;
            step = (step.key < nextKey) ? step.right : step.left;
        }
        return null;
    }

    public find(key: number, color: number = 0): NodeOfBTree<T> {
        this.clearColorNode();
        let step: NodeOfBTree<T> = this.treeHead;
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
    }

    public delete(key: number): void {
        if (this.empty()) {
            console.log("There is nothing in the tree");
            return;
        }
        const parentNode: NodeOfBTree<T> = this.parent(key);
        const delNode: NodeOfBTree<T> = this.find(key, 1);
        if (delNode === null) {
            alert("Элемента с таким ключом нет!");
            return;
        }
        if ((delNode?.left == null) && (delNode?.right == null)) {
            if (parentNode == null) {
                this.treeHead?.div.remove();
                this.treeHead = null;
            } else if (parentNode?.left === delNode) {
                delNode?.div.remove();
                parentNode.setLeft(null);
            } else {
                delNode?.div.remove();
                parentNode.setRight(null);
            }
        } else if ((delNode?.left == null) || (delNode?.right == null)) {
            if (delNode?.left == null) {
                if (parentNode == null) {
                    if (delNode.right !== null) {
                        delNode.right.div.className = "treeBody";
                        this.div?.append(delNode.right.div);
                    }
                    this.treeHead = delNode.right;
                } else if (parentNode?.left === delNode) {
                    parentNode.setLeft(delNode?.right);
                    if (delNode.right !== null) {
                        delNode.right.div.className = "nodeLeft";
                        parentNode.div.append(delNode.right.div);
                    }
                } else {
                    parentNode.setRight(delNode?.right);
                    if (delNode.right !== null) {
                        parentNode.div.append(delNode.right.div);
                    }
                }
            } else {
                if (parentNode == null) {
                    if (delNode.left !== null) {
                        delNode.left.div.className = "treeBody";
                        this.div?.append(delNode.left.div);
                    }
                    this.treeHead = delNode.left;
                } else if (parentNode?.left === delNode) {
                    parentNode.setLeft(delNode?.left);
                    if (delNode.left !== null) {
                        parentNode.div.append(delNode.left.div);
                    }
                } else {
                    parentNode.setRight(delNode?.left);
                    if (delNode.left !== null) {
                        delNode.left.div.className = "nodeRight";
                        parentNode.div.append(delNode.left.div);
                    }
                }
            }
            delNode.div.remove();
        } else {
            let replaceNode: NodeOfBTree<T> = delNode.right;
            let parentReplaceNode: NodeOfBTree<T> = delNode;
            while (replaceNode.left != null) {
                parentReplaceNode = replaceNode;
                replaceNode = replaceNode?.left;
            }
            if (replaceNode.right != null) {
                if (parentReplaceNode === delNode) {
                    parentReplaceNode.div.append(replaceNode.right.div);
                    parentReplaceNode.right = replaceNode.right;
                } else {
                    replaceNode.right.div.className = "nodeLeft";
                    parentReplaceNode.div.append(replaceNode.right.div);
                    parentReplaceNode.left = replaceNode.right;
                }
            } else {
                if (parentReplaceNode === delNode) {
                    parentReplaceNode.right?.div.remove();
                    parentReplaceNode.right = null;
                    delNode.div.remove();
                } else {
                    parentReplaceNode.left?.div.remove();
                    parentReplaceNode.left = null;
                    delNode.div.remove();
                }
            }
            if (parentNode != null) {
                if (parentNode?.left === delNode) {
                    replaceNode.div.className = "nodeLeft";
                    parentNode.div.append(replaceNode.div);
                    parentNode.setLeft(replaceNode);
                } else {
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
                this.div?.append(replaceNode.div);
                this.treeHead = replaceNode;
            }
            delNode.div.remove();
        }
    }

    public print(curNode: NodeOfBTree<T> = this.treeHead): void {
        if (this.treeHead == null) {
            console.log("There is nothing in the tree");
            return;
        }
        if (curNode != null) {
            console.log(curNode.value);
            this.print(curNode?.left);
            this.print(curNode?.right);
        }
    }
}

function setColor(node: NodeOfBTree<number>, color: number): void {
    node?.setColor(color);
}

let resultFind: HTMLElement = document.createElement("div");
resultFind.className = "resultFind";
document.getElementById("findCoeff")?.append(resultFind);
let tree: BinaryTree<number> = new BinaryTree<number>();
tree.div = document.getElementById("treeBody");

function pressInpBut(): void {
    resultFind.innerHTML = "";
    let key: number | null = null;
    let val: number | null = null;
    let tmp = (<HTMLInputElement>document.getElementById("inpKey")).value;
    if (typeof tmp === "string") {
        if (tmp !== "") {
            key = +tmp;
        }
    }
    tmp = (<HTMLInputElement>document.getElementById("inpVal")).value;
    if (typeof tmp === "string") {
        if (tmp !== "") {
            val = +tmp;
        }
    }
    if ( (val !== null) && (key !== null)) {
        tree.add(key, val);
    }

}

function pressDelBut(): void {
    resultFind.innerHTML = "";
    let key: number | null = null;
    const tmp = (<HTMLInputElement>document.getElementById("delKey")).value;
    if (typeof tmp === "string") {
        if (tmp !== "") {
            key = +tmp;
        }
    }
    if (key !== null) {
        tree.delete(key);
    }
}

function pressFindBut(): void {
    let key: number | null = null;
    const tmp = (<HTMLInputElement>document.getElementById("findKey")).value;
    if (typeof tmp === "string") {
        if (tmp !== "") {
            key = +tmp;
        }
    }
    if (key !== null) {
        const res =  tree.find(key, 3)?.value;
        let resString: string = "";
        if (typeof res === "number") {
            resString = "Значение при заданном ключе: " + res;
        } else if ( (typeof res === null) || ( res === undefined) ) {
            resString = "Ваше значение при заданном ключе не найдено";
        }
        resultFind.innerHTML = resString;
    }
}

document.getElementById("inpButton")?.setAttribute("onclick", "pressInpBut()");
document.getElementById("delButton")?.setAttribute("onclick", "pressDelBut()");
document.getElementById("findButton")?.setAttribute("onclick", "pressFindBut()");

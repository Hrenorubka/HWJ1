class NodeOfTree<T> {
    public right: NodeOfTree<T> | null;
    public left: NodeOfTree<T> | null;
    private _value: T;
    private _key: number;
    public constructor(value: T, key: number) {
        this._value = value;
        this.right = null;
        this.left = null;
        this._key = key;
    }

    public get key(): number {
        return this._key;
    }

    public addLeft(value: T, key: number): void {
        this.left = new NodeOfTree(value, key);
    }
    public addRight(value: T, key: number): void {
        this.right = new NodeOfTree(value, key);
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

}

type NodeOfBTree<T> = NodeOfTree<T> | null;

class BinaryTree<T> {
    private treeHead: NodeOfBTree<T>;

    public constructor() {
        this.treeHead = null;
    }

    public empty(): boolean {
        return (this.treeHead === null);
    }

    public add(value: T, key: number): void {
        if (this.treeHead != null) {
            let step: NodeOfBTree<T>  = this.treeHead;
            while (step != null) {
                if (step.key < key) {
                    if (step.right == null) {
                        step.right = new NodeOfTree(value, key);
                        break;
                    }
                    step = step.right;
                } else if (step.key > key) {
                    if (step.left == null) {
                        step.left = new NodeOfTree(value, key);
                        break;
                    }
                    step = step.left;
                } else {
                    console.log("Ошибка");
                }
            }
        } else {
            this.treeHead = new NodeOfTree(value, key);
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
            /*if (step.key < nextKey) {
                step = step.right;
            } else {
                step = step.left;
            }*/
        }
        return null;
    }

    public find(key: number): NodeOfBTree<T> {
        let step: NodeOfBTree<T> = this.treeHead;
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
    }

    public delete(key: number): void {
        if (this.empty()) {
            console.log("There is nothing in the tree");
            return;
        }
        // let
        const parentNode: NodeOfBTree<T> = this.parent(key);
        // let
        const delNode: NodeOfBTree<T> = this.find(key);
        if ((delNode?.left == null) && (delNode?.right == null)) {
            if (parentNode == null) {
                this.treeHead = null;
            } else if (parentNode?.left === delNode) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        } else if ((delNode?.left == null) || (delNode?.right == null)) {
            if (delNode?.left == null) {
                if (parentNode == null) {
                    this.treeHead = delNode.right;
                } else if (parentNode?.left === delNode) {
                    parentNode.setLeft(delNode?.right);
                } else {
                    parentNode.setRight(delNode?.right);
                }
            } else {
                if (parentNode == null) {
                    this.treeHead = delNode.left;
                } else if (parentNode?.left === delNode) {
                    parentNode.setLeft(delNode?.left);
                } else {
                    parentNode.setRight(delNode?.left);
                }
            }
        } else {
            let replaceNode: NodeOfBTree<T> = delNode.right;
            let parentReplaceNode: NodeOfBTree<T> = delNode;
            while (replaceNode.left != null) {
                parentReplaceNode = replaceNode;
                replaceNode = replaceNode?.left;
            }
            if (replaceNode.right != null) {
                if (parentReplaceNode === delNode) {
                    parentReplaceNode.right = replaceNode.right;
                } else {
                    parentReplaceNode.left = replaceNode.right;
                }
            } else {
                if (parentReplaceNode === delNode) {
                    parentReplaceNode.right = null;
                } else {
                    parentReplaceNode.left = null;
                }
            }
            if (parentNode != null) {
                if (parentNode?.left === delNode) {
                    parentNode.setLeft(replaceNode);
                } else {
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

let tree: BinaryTree<number> = new BinaryTree<number>();
let exitFlag: number = 0;


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

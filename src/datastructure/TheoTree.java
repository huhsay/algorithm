package datastructure;

public class TheoTree<E extends Comparable> {
    private E value;
    private TheoTree leftTree;
    private TheoTree rightTree;

    public TheoTree(E value, TheoTree leftTree, TheoTree rightTree) {
        this.value = value;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public boolean search(final E toFind) {
        if (this.value.equals(toFind)) return true;

        if (toFind.compareTo(value) < 0 && leftTree != null) {
            return leftTree.search(toFind);
        }

        return rightTree != null && rightTree.search(toFind);
    }

    public void insert(final E toInsert) {
        if( toInsert.compareTo(value) < 0) {
            if( leftTree == null){
                leftTree = new TheoTree(toInsert, null, null);
            }else {
                leftTree.insert(toInsert);
            }
        }else{
            if(rightTree == null){
                rightTree = new TheoTree(toInsert, null, null);
            }else{
                rightTree.insert(toInsert);
            }
        }
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public TheoTree getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(TheoTree leftTree) {
        this.leftTree = leftTree;
    }

    public TheoTree getRightTree() {
        return rightTree;
    }

    public void setRightTree(TheoTree rightTree) {
        this.rightTree = rightTree;
    }
}

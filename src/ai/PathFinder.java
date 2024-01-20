package ai;

import entity.Entity;
import main.GamePanel;

import java.util.ArrayList;


/*
    THIS WHOLE ALGORITHM IS A* SEARCH ALGORITHM!

    THEORY: https://en.wikipedia.org/wiki/A*_search_algorithm
    CODE INSPIRATION: https://codegym.cc/groups/posts/a-search-algorithm-in-java


    These inspiration and theoretical information were used, transformed and changed for our
    needs and project. Therefor not much commentary is used to describe this part of the code.
    If information needed, check out provided link or search about A* search algorithm.
*/


public class PathFinder {
    GamePanel gamePanel;
    Node[][] node;
    ArrayList<Node> openList = new ArrayList<>();
    public ArrayList<Node> pathList = new ArrayList<>();
    Node startNode, goalNode, currentNode;
    boolean goalReached = false;
    int step = 0;

    public PathFinder(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        instantiateNodes();
    }

    public void instantiateNodes() {
        node = new Node[gamePanel.maxMapCol][gamePanel.maxMapRow];

        int col = 0;
        int row = 0;

        while(col < gamePanel.maxMapCol && row < gamePanel.maxMapRow) {
            node[col][row] = new Node(col, row);
            col++;
            if(col == gamePanel.maxMapCol) {
                col = 0;
                row++;
            }
        }
    }

    public void resetNodes() {
        int col = 0;
        int row = 0;

        while (col < gamePanel.maxMapCol && row < gamePanel.maxMapRow) {

            // Reset open, checked and solid state
            node[col][row].open = false;
            node[col][row].checked = false;
            node[col][row].solid = false;

            col++;
            if(col == gamePanel.maxMapCol) {
                col = 0;
                row++;
            }
        }

        // Reset other settings
        openList.clear();
        pathList.clear();
        goalReached = false;
        step = 0;
    }

    public void setNodes(int startCol, int startRow, int goalCol, int goalRow, Entity entity) {

        resetNodes();

        // Set Start and Goal node
        startNode = node[startCol][startRow];
        currentNode = startNode;
        goalNode = node[goalCol][goalRow];
        openList.add(currentNode);

        int col = 0;
        int row = 0;

        while (col < gamePanel.maxMapCol && row < gamePanel.maxMapRow) {

            // SET SOLID NODE
            // CHECK TILES
            int tileNum = gamePanel.manager.mapTilesNum[gamePanel.currentMap][col][row];
            if (gamePanel.manager.tile[tileNum].collision) {
                node[col][row].solid = true;
            }

            // SET COST
            getCost(node[col][row]);
            col++;
            if (col == gamePanel.maxMapCol) {
                col = 0;
                row++;
            }
        }
    }

    public void getCost(Node node){

        // G cost
         int xDistance = Math.abs(node.col - startNode.col);
         int yDistance = Math.abs(node.row - startNode.row);
         node.gCost = xDistance + yDistance;

         // H cost
        xDistance = Math.abs(node.col - goalNode.col);
        yDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xDistance + yDistance;

        // F cost
        node.fCost = node.gCost + node.fCost;
    }

    public boolean search() {
        while(!goalReached  && step < 500) {
            int col = currentNode.col;
            int row = currentNode.row;

            // Check the current node
            currentNode.checked = true;
            openList.remove(currentNode);

            // Open the Up node
            if(row - 1 >= 0) openNode(node[col][row - 1]);
            if(col - 1 >= 0) openNode(node[col - 1][row]);
            if(row + 1 < gamePanel.maxMapRow)   openNode(node[col][row + 1]);
            if(col + 1 < gamePanel.maxMapCol)   openNode(node[col + 1][row]);

            // Find the best node
            int bestNodeIndex = 0;
            int bestNodefCost  = 999;

            for(int i = 0; i < openList.size(); i++) {

                // Check if this node's F cost is better
                if(openList.get(i).fCost < bestNodefCost) {
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                }

                // If F cost is equal, check the  G cost
                else if(openList.get(i).fCost == bestNodefCost)
                    if(openList.get(i).gCost < openList.get(bestNodeIndex).gCost)
                        bestNodeIndex = i;

            }

            // If there is no node in the openList, end the Loop
            if(openList.isEmpty())  break;


            // After the loop, open openList[bestIndex] is the next step (= currentNode)
            currentNode = openList.get(bestNodeIndex);

            if(currentNode == goalNode) {
                goalReached = true;
                trackThePath();
            }
            step++;
        }

        return goalReached;
    }

    public void openNode(Node node) {
        if(!node.open && !node.checked && !node.solid) {
            node.open = true;
            node.parent = currentNode;
            openList.add(node);
        }
    }

    public void trackThePath() {
        Node current = goalNode;

        while(current != startNode) {

            pathList.add(0, current);
            current = current.parent;
        }
    }
}

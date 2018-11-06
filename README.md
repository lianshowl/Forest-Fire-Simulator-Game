# Forest-Fire-Simulator-Game
[Assignment 1 Full Description](https://https://www2.seas.gwu.edu/~simhaweb/cs2113/hw/a1/a1.html)

 Here, the landscape is going to be 2-dimensional grid of cells, each of which either contain a tree or not. This rudimentary landscape is useful in studying burn patterns, safety measures and the effects of a "controlled burn".

For example, here is a 5 x 5 grid with 17 trees, represented with ones and zeroes (1 = tree).

   1 1 1 0 1
   0 0 1 0 1
   0 1 1 1 0
   1 0 1 1 1
   1 1 0 1 1
And here is a 3 x 3 grid with 5 trees:
   1 1 1
   0 0 0
   0 1 1

Time steps in simulating an actual burn:  
We will simulate a forest fire by changing the state of the landscape at each step. This is similar to changing the configuration of a chessboard with each move of a player. Thus, prior to step 1 is the initial configuration. Then, some trees are ignited. In step 2, we mark the ignited trees as "burning" and ignite neighbors (according to the "ignite" rules). In step 3, those that were burning are now considered burnt (according to "burn rate" rules), and those that were ignited are marked "burning". "Burn" rule for Type-1 trees: they burn completely in one simulation step once they've started burning. "Burn" rule for Type-2 trees: they take two steps to burn down. (In the first step, they are considered "burning"). To help clarify what happens in each step, think of the steps as taking 10 seconds (or whatever) each and presume that all igniting occurs in a fraction of a second at the end of the 10-second period. Then, before the first step (Step 1) the ignition pattern is provided. These ignited trees will burn during Step 1, and thus they can be considered "burning" during Step 1. Towards the end of the 10-second Step 1 period, these burning trees ignite neighbors. Those neighbors then burn in Step 2, etc. Now, a type-2 tree that was burning in Step 1 will continue to burn in Step 2. Your simulation will run until all trees that get ignited (at any time) completely burn (as opposed to running the simulation for a fixed number of steps). Thus, one tree can ignite another, then the second burns, igniting a third, etc. Since there are a limited number of trees, the burning cannot continue indefinitely, so the simulation must end. Some trees that never get ignited, of course, are left unburned.

When a tree catches fire, it ignites every tree in a neighboring cell. An ignited tree does not ignite its non-neighbors.
Now consider what happens when a particular tree is ignited. The tree itself catches fire and ignites its neighbors, which in turn ignite their neighbors, and so on. All these trees eventually burn down. Eventually, the burning stops and we are left with the stumps of a cluster. Thus, a cluster is a collection of trees, such that any two trees in the cluster are connected to each other via a string of neighboring trees. Hence, in the example below
   1 1 1
   0 0 0
   0 1 1
there are two clusters. The cluster
   x x x
   0 0 0
   0 1 1
and the cluster
   1 1 1
   0 0 0
   0 x x
It is clear that if any tree in a cluster is ignited, the entire cluster will eventually burn.
We will consider trees with different "burn" properties:
There will be two types of trees. Let's call them "type-1" and "type-2" trees.
-Type-1 trees are like the trees described so far: if any neighboring tree catches fire, they catch fire.
-Type-2 trees are "sturdier". It requires two neighboring trees to be on fire (simultaneously) for a type-2 tree to catch fire.



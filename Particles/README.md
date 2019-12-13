## Particles

This is an attempt to create the following in python:

1. Generate circles/particles as objects.
   * Particles size is randomly generated;
   * Particles position is randomly generated;
   * Particles color is randomly generated;
   * Particles movement speed is randomly generated;
2. Generate as many random particles as desired and populate a working environment with them that can be visualized with matplotlib package.
3. Allow particles to move, which is represented through the animation of the matplotlib visualized figure.

---
__Conditions:__

* Particles can be only of 4 different colors.
* Some particles seek to primarily move left-right, others up-down, but all can..."gitter" (i.e. produce random movement), but on smaller scale.
* As soon as a moving particle reaches the edge of 100x100 field - it changes color and moves in the opposite direction.
* The subplot 2 on the right side visualizes the dominance of one color of particles over others. It is also updatable.

---
__Requirements:__

1. Have installed packages:
   * matplotlib
   * pandas
   * numpy
2. Copy the .py file into your folder and you can execute it via cmd/terminal by running:
`python ParticlesMovement.py -p 100`
A value after -p can be changed to the amount of particles you want to run for your case, that will be visualized. 
For additional information and help you can run command:
`python ParticlesMovement.py -h`

---
__WARNING:__

Currenly in the code line 240 has a command

```{python}
fig.savefig('Particles_Example.png')
```

It will save the visualization of the plots you are producing. It is recommended to reduce the delays in execution of the code.
Currently this function was added just to save an example for visual demonstration of the program running.

---
__EXAMPLE:__

![alt text](https://github.com/Si-ja/Random-Projects/blob/master/Particles/Particles_Example.png "Example")

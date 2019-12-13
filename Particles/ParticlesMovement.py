import argparse
from argparse import RawTextHelpFormatter

parser = argparse.ArgumentParser(description = "\t\t\t\tDescription:\n"
                                               "---------------------------------------------------------------------\n"
                                               "Creates a simulation of randomly moving particles in a field.\n\n"
                                               "\t\t\t\tRequirements:\n"
                                               "----------------------------------------------------------------------\n"
                                               "\t\t\t\t> matplotlib\n"
                                               "\t\t\t\t> pandas\n"
                                               "\t\t\t\t> numpy\n"
                                               "----------------------------------------------------------------------",
                                 formatter_class = RawTextHelpFormatter)

parser.add_argument("-p", "--amount_particles",
                    type = int,
                    metavar = "",
                    help = "Indicate how many particles you want the simulation to run.")
args = parser.parse_args()

def all_in_one(amount_particles = 10):
    class Particle:
        """
        Create a particle with x position, y position and size. All are generated randomly.
        Available methods:
        > retrive_x
        > retrive_y
        > retrive_size
        """

        def __init__(self):
            """Initiate the random nature of the particle.
            No arguments are needed to be passed."""
            from numpy.random import randint as rng
            self.x = rng(low = 0, high = 100) # position on x axis
            self.y = rng(low = 0, high = 100) # position on y axis
            self.s = rng(low = 0, high = 100) # size of the particle

            # colors_list = ["b", "g", "r", "c", "m", "y", "k", "w"]
            colors_list = ["b", "g", "r", "m"]
            self.c = colors_list[int(rng(low = 0, high = len(colors_list)))] # color of the particle

        def retrive_x(self):
            """Return the position of the particle on the x axis."""
            return self.x

        def retrive_y(self):
            """Return the position of the particle on the y axis."""
            return self.y

        def retrive_size(self):
            """Return the size of the particle."""
            return self.s

        def retrive_color(self):
            """Return the color of the particle."""
            return self.c

        def move_down(self):
            from numpy.random import uniform as rng_float
            self.y -= round(rng_float(low = 0.0, high = 0.25), 2)

        def move_up(self):
            from numpy.random import uniform as rng_float
            self.y += round(rng_float(low = 0.0, high = 0.25), 2)

        def move_left(self):
            from numpy.random import uniform as rng_float
            self.x -= round(rng_float(low = 0.0, high = 0.25), 2)

        def move_right(self):
            from numpy.random import uniform as rng_float
            self.x += round(rng_float(low = 0.0, high = 0.25), 2)

        def set_color(self, color):
            "Pass a color type to re-set the color of the particle"
            self.c = color

        def move_random(self):
            """Literaly move in a random formation"""
            from numpy.random import randint as rng
            direction = ["up", "down", "left", "right"]
            direction_choice = direction[int(rng(low = 0, high = len(direction)))]

            if direction_choice == "up":
                self.move_up()
            elif direction_choice == "down":
                self.move_down()
            elif direction_choice == "right":
                self.move_right()
            else:
                self.move_left()

    particles_amount = int(amount_particles)
    # Generate many particles:
    import matplotlib.pyplot as plt
    import matplotlib.animation as animation
    import pandas as pd
    import matplotlib as mpl
    mpl.rcParams['figure.dpi'] = 100

    particles = [Particle() for _ in range(particles_amount)]

    xmin = 0
    xmax = 100
    ymin = 0
    ymax = 100

    fig = plt.figure()
    ax1 = fig.add_subplot(1,2,1)
    ax1.set_xlim([xmin,xmax])
    ax1.set_ylim([ymin,ymax])
    ax2 = fig.add_subplot(1,2,2)

    # Turn off the ticks on both x and y axes of the first plot
    ax1.tick_params(axis=u'both',
                    which=u'both',
                    length=0,
                    labelsize=0)

    def animate(i):
        import numpy as np
        _xs = []
        _ys = []
        _ss = []
        _cs = []
        n_r, n_b, n_m, n_g = 0, 0, 0, 0
        bg_c = "w"
        for particle in particles:
            x, y = particle.retrive_x(), particle.retrive_y()
            s, c, = particle.retrive_size(), particle.retrive_color()
            _xs.append(x)
            _ys.append(y)
            _ss.append(s)
            _cs.append(c)
            # Check on the x axis that all particles are inside of their bounds:
            if particle.retrive_color() == "r":
                if particle.retrive_x() < 98:
                    particle.move_right()
                    particle.move_right()
                    particle.move_random()
                if particle.retrive_x() > 97:
                    particle.set_color("b")

            if particle.retrive_color() == "b":
                if particle.retrive_x() > 2:
                    particle.move_left()
                    particle.move_left()
                    particle.move_random()
                if particle.retrive_x() < 3:
                    particle.set_color("r")

            if particle.retrive_color() == "g":
                if particle.retrive_y() > 2:
                    particle.move_down()
                    particle.move_down()
                    particle.move_random()
                if particle.retrive_y() < 3:
                    particle.set_color("m")

            if particle.retrive_color() == "m":
                if particle.retrive_y() < 98:
                    particle.move_up()
                    particle.move_up()
                    particle.move_random()
                if particle.retrive_y() > 97:
                    particle.set_color("g")

            if (particle.retrive_x() < 50 and particle.retrive_x() > 45) or (particle.retrive_x() > 50 and particle.retrive_x() > 95):
                particle.move_left()
                particle.move_random()
            if particle.retrive_x() > 50 and particle.retrive_x() < 55 or (particle.retrive_x() < 50 and particle.retrive_x() < 5):
                particle.move_right()
                particle.move_random()

            # Now check on the y axis
            if particle.retrive_y() > 95:
                particle.move_down()
                particle.move_random()
            if particle.retrive_y() < 5:
                particle.move_up()
                particle.move_random()

            # Set condition to jiggle around otherwise
            else:
                particle.move_random()

            # Collector of which particles are the most:
            if particle.retrive_color() == "r":
                n_r += 1
            if particle.retrive_color() == "b":
                n_b += 1
            if particle.retrive_color() == "m":
                n_m += 1
            if particle.retrive_color() == "g":
                n_g += 1

            org_list = np.array([n_r, n_b, n_m, n_g])
            temp_list = np.max(org_list)
            new_list = []
            for value in org_list:
                if value == temp_list:
                    new_list.append(value)
            if len(np.array(new_list)) > 1:
                bg_c = "white"
            elif n_r == temp_list:
                bg_c = "red"
            elif n_b == temp_list:
                bg_c = "blue"
            elif n_m == temp_list:
                bg_c = "magenta"
            else:
                bg_c = "green"

        df = pd.DataFrame({"Colors": ["Red", "Blue", "Magenta", "Green"],
                           "Frequency": org_list})

        ax1.clear()
        ax2.clear()

        ax1.scatter(_xs, _ys, c = _cs, s = _ss, edgecolors  = "black", linewidth = 0.2)
        ax1.plot([50, 50], [0, 100], c = "black")
        ax1.plot([0, 0], [0, 100], c="black")
        ax1.plot([100, 100], [0, 100], c="black")
        ax1.plot([0, 100], [0, 0], c="black")
        ax1.plot([0, 100], [100, 100], c="black")
        if bg_c != "white":
            ax1.text(10, 50, r'Dominant Color: {}'.format(bg_c), fontsize=10, color='white', fontweight='bold', alpha = 0.5)
        ax1.patch.set_facecolor(bg_c)
        ax1.patch.set_alpha(0.5)

        ax2.bar(df["Colors"], height = df["Frequency"], color = ("r", "b", "m", "g"))

    ani = animation.FuncAnimation(fig, animate, interval = 40)
    plt.show()
    
    # This piece of code is written just to save an example of the figure that will be outputed
    # Recommendation: Comment it out and do not use, as it will only slow down the execution of the
    # Code even more
    fig.savefig('Particles_Example.png')

if __name__ == "__main__":
    all_in_one(args.amount_particles)
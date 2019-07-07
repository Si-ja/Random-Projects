from tkinter import *
import sys, os, io, random
from numpy.random import randint as rng_gen

#Load all the characters
CHAR_UP = ['\u030D', '\u030E', '\u0304', '\u0305', '\u033F',
           '\u0311', '\u0306', '\u0310', '\u0352', '\u0357',
           '\u0351', '\u0307', '\u0308', '\u030A', '\u0342',
           '\u0343', '\u0344', '\u034A', '\u034B', '\u034C',
           '\u0303', '\u0302', '\u030C', '\u0350', '\u0300',
           '\u0301', '\u030B', '\u030F', '\u0312', '\u0313',
           '\u0314', '\u033D', '\u0309', '\u0363', '\u0364',
           '\u0365', '\u0366', '\u0367', '\u0368', '\u0369',
           '\u036A', '\u036B', '\u036C', '\u036D', '\u036E',
           '\u036F', '\u033E', '\u035B', '\u0346', '\u031A']

CHAR_MID = ['\u0315', '\u031B', '\u0340', '\u0341', '\u0358',
            '\u0321', '\u0322', '\u0327', '\u0328', '\u0334',
            '\u0335', '\u0336', '\u034F', '\u035C', '\u035D',
            '\u035E', '\u035F', '\u0360', '\u0362', '\u0338',
            '\u0337', '\u0361', '\u0489']

CHAR_DOWN = ['\u0316', '\u0317', '\u0318', '\u0319', '\u031C',
             '\u031D', '\u031E', '\u031F', '\u0320', '\u0324',
             '\u0325', '\u0326', '\u0329', '\u032A', '\u032B',
             '\u032C', '\u032D', '\u032E', '\u032F', '\u0330',
             '\u0331', '\u0332', '\u0333', '\u0339', '\u033A',
             '\u033B', '\u033C', '\u0345', '\u0347', '\u0348',
             '\u0349', '\u034D', '\u034E', '\u0353', '\u0354',
             '\u0355', '\u0356', '\u0359', '\u035A', '\u0323']

def zalgo(val):
    #Create a list of all directions we need to go glitching everything out
    glitch_list = []
    if glitch_up.get() == 1:
        glitch_list.append("CHAR_UP")
    if glitch_med.get() == 1:
        glitch_list.append("CHAR_MID")
    if glitch_down.get() == 1:
        glitch_list.append("CHAR_DOWN")
    #Shuffle the list for bigger randomness
    random.shuffle(glitch_list)

    #Get our text:
    inputValue = str(mtext_1.get("1.0", "end-1c"))

    #Bound to apply our hellanizator for the extremes
    lower_bound_chaos = 0
    upper_bound_chaos = int(var.get())

    #Get our text:
    mod_text = list(inputValue)

    #Start the adding of layers
    usable_set = 0
    for insanity in glitch_list:
        if insanity == "CHAR_UP":
            usable_set = CHAR_UP
        elif insanity == "CHAR_DOWN":
            usable_set = CHAR_DOWN
        else:
            usable_set = CHAR_MID

        #Boundries for our values in the characters sets we will use:
        lower_bound_characters = 0
        upper_bound_characters = len(usable_set) - 1

        #Step 1: Now let's go for the polishing of our text, break it into parts
        #Skip...done previously

        if gradual.get() == 1:
            gradual_eval_1 = len(inputValue)*0.15
            gradual_eval_2 = len(inputValue)*0.3
        else:
            gradual_eval_1 = 0
            gradual_eval_2 = 0

        #Step 2: For each character apply our glitch effect:
        for position, character in enumerate(mod_text):
            if gradual_eval_1 >= position:
                continue
            elif gradual_eval_2 >= position:
                if rng_gen(0, 11) <= 3:
                    continue
            else:
                i_start = lower_bound_chaos + upper_bound_chaos / 10 #Amount of possible scrambles from start
                i_end   = upper_bound_chaos                          #Amount of possible scrambles to the end

                while i_start <= i_end:
                    #Apply a random letter as a glitch
                    glitch = rng_gen(lower_bound_characters, upper_bound_characters)
                    character = character + usable_set[glitch]
                    i_start += 1
                mod_text[position] = character

    #Step 3: put the text back together:
    final_text = "".join(mod_text)

    #Step 4: return the finalized product and show to the user
    #Past the text back into the other window
    mtext_2.delete("1.0", END)
    mtext_2.insert("insert", final_text)
 
    #Save the text - commented out for now, but this is how you can save it
    #file = io.open("zalgo.txt", "w", encoding="utf-8")
    #file.write(final_text) 
    #file.close()

def copy_to_clip():
    #Get text and copy it to a clipboard
    copy_text = str(mtext_2.get("1.0", "end-1c"))
    mGui.clipboard_clear()
    mGui.clipboard_append(copy_text)


#--------------------Tkinter part / GUI------------------------------------
mGui = Tk()

mGui.geometry("650x700+375+100")   #Size of the window
mGui.title("Zalgo Text Converter") #Title of the program

#Label for greating the user placement
mlabel_1 = Label(mGui, text = "Convert your text into an unholy creation from Hell",
               fg = "red")
mlabel_1.config(font = ("Rockewell", 12))
mlabel_1.pack(padx=10, pady=10)

mlabel_2 = Label(mGui, text = "Enter your text here:")
mlabel_2.config(font = ("Rockwell", 12))
mlabel_2.pack()

#Text box
mtext_1 = Text(mGui, height = 10, width = 60)
mtext_1.pack(padx=10, pady=10)

#Button to generate text:
#mbutton = Button(mGui, text = "Scramble text", command = zalgo).pack(padx=20, pady=20)

#New window for output text
mtext_2 = Text(mGui, height = 10, width = 60)
mtext_2.pack(padx=10, pady=10)

#Sliders for controlling insanity
mlabel_3 = Label(mGui, text = "How insane do you want this to be?")
mlabel_3.config(font = ("Rockwell", 12))
mlabel_3.pack()

var = DoubleVar()
slider = Scale(mGui,
               orient = HORIZONTAL,
               length = 450,
               width = 15,
               tickinterval = 20,
               variable = var,
               command = zalgo)
slider.set(0)
slider.pack(padx=15, pady=10)

#Checkboxes for deciding into what directions should the text be messed up:
glitch_up = IntVar()
glitch_med = IntVar()
glitch_down = IntVar()
gradual = IntVar()

check_u = Checkbutton(mGui, text = "Glitch upwards",     variable = glitch_up).pack()
check_m = Checkbutton(mGui, text = "Glitch to the side", variable = glitch_med).pack()
check_d = Checkbutton(mGui, text = "Glitch downwards",   variable = glitch_down).pack()

#Check box if we want a gradual chaos increase:
check_grad = Checkbutton(mGui, text = "Gradual Increase?",variable = gradual).pack()

#Copy to clipboard button:
mbutton_1 = Button(mGui, text = "Copy to Clipboard", command = copy_to_clip)
mbutton_1.pack(padx=15, pady=10)



mGui.mainloop() #Keep this running


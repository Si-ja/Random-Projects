#The pirates, the coconuts and the monkey problem.
#Python based solution, this accounting for when there is only 1 pirate.
#This one accounts also for trying to comment what actually is going on with the whole case.

#The answers if you want to compare them are the following (do note that with anything above 7 pirates it takes time to run):
#{1: None, 2: 7, 3: 79, 4: 1021, 5: 15621, 6: 517309, 7: 5764795, 8: 134217721}
#It started taking more than 10 minutes pass 8. As you cann see, numbers grow at insane speed.

def pirates(crew):
    
	#Check if the value of pirates is smaller than 0. There is no point in counting that.
    if crew <= 0:
        print("Number of crew members seems to be smaller or equal to zero. Please re-evaluate your equation!")
        return

	#Check if the value provided is an integer. We want to stick to realizm of having FULL people.
    if crew/int(round(crew, 1)) != 1:
        print("The value for the crew members is not an integer full value!")
        return

	#Obviously if we have one pirate the calculations are simple and can be provided straight away.
	#Do not with a print() statement that this though is trivial and maybe not something the user wants to go for.
    if crew == 1:
        coconuts = 2
        print(coconuts)
        print("But re-evaluation needs to be done, as the puzzle is not based on such conditions where there is only 1 pirate!")
        return
    
	#Make calculations for any other conditions (i.e. when number of crew members is 2 or more)
	#Do note that this actually requires some time to execute with amounts of pirates being more than 5-6
	#Depends on your computer.
	
    coconuts = 1       			#Get a starting point of how many cocounts we have
    pile = coconuts    			#This will change our pile while evaluating where that breaking point is for our solution
    i = 0              			#Start itterations from somewhere (prefereably 0) as we will be using a while loop
    while i < crew+1:  			#Itterations will go based on how many pirates we have in our crew
	
        if pile%crew == 1:      #if by removing cocounts we will get to the point where 1 coconut is left we will
		                        #update our pile and that last coconut will go to the monkey
								
            pile = int((1/crew * (crew-1))*(pile-1)) #Fun thing is...I do not remember how and why this works
			                                         #More than a year passed since then. It works. But why?
													 #I don't honestly remember the math behind it.
													 #But I believe the calculation work the following way:
													 #If we have a perfect stack that can be devided as required ->
													 #Devide that stack. Check if the conditions are perfect again ->
													 #If they are movement goes further and it is checked whether all
													 #Of the pirates can perform an action that satisfies the conditions.
													 #If they cannot, we will move to an else condition and increase
													 #Our pile by 1 and check if that stack would satisfiy our conditions.
													 
													 #That is why we have a pile variable - it deminishes as we check
													 #Our conditions. And coconuts variable that is a sudo pile that is
													 #Like kept in memory of where we started checking our conditions.
			
				 
            i += 1              #Start calculations for the next crew member if he satisfies the conditions as well
			
        else:                   #if dividing the coconuts does not lead us to the point where one is left we move to an
		                        #alternative condition:
								
            coconuts += 1       #Add a coconut as there are not enough
            i = 0               #Start all the calculations again (this is the part because of which our calculations
			                    #can take so long
								
            pile = coconuts     #Update the amount of coconuts in our pile
            continue
    print(coconuts)				#Because this is a self containing program, we will print the pile instead of returning it
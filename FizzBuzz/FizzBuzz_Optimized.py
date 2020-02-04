class FizzBuzz:

    def __init__(self, start, end):
        """Initiate conditions where the fizzbuzz will start and end at"""
        self.__start = start
        self.__end   = end + 1
        
    def verify(self, idx):
        """A verifying method to keep less conditions pre-occupied. Also re-optimized"""
        answer = str("")
        
        if idx % 3 == 0 : answer += "Fizz"
        if idx % 5 == 0 : answer += "Buzz" 
        return answer if answer != "" else idx
        
    def fizzbuzz(self):
        """Prepare the printing instance of required fizzbuzz conditions"""
        for idx in range(self.__start, self.__end):
            print(self.verify(idx))
     
if __name__ == "__main__": 
    myObj = FizzBuzz(1, 15)
    myObj.fizzbuzz()
# FizzBuzz in R

div_3_num <- 3
div_5_num <- 5

div_3_word <- "Fizz"
div_5_word <- "Buzz"

start_point <- 1
end_point <- 100

for (i in start_point:end_point) {
  answer <- ""
  answer <- paste(answer, ifelse(i %% div_3_num == 0, div_3_word, ""), sep = "") 
  answer <- paste(answer, ifelse(i %% div_5_num == 0, div_5_word, ""), sep = "")
  if (answer == "") {
    answer <- i
  }
  print(answer)
}


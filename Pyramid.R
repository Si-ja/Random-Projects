# Pyramid drawing in levels (top down)
#----------Setup----------
levels <- 5

##----------Calculations and Execution#----------
visualized <- (levels * 2) - 1 

pyramid <- matrix(levels, nrow = visualized, ncol= visualized)
idx <- 1
for (i in levels:1) {
  pyramid[c(idx:(visualized - (idx - 1))), c(idx:(visualized - (idx - 1)))] <- i
  idx <- idx + 1
}

pyramid
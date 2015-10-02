
lambda = 0.9
n = 1000
mean = (lambda * (n - 1)).fdiv(n)

puts mean

while n!=2000
  n = n + 10
  mean = (lambda * (n - 1)).fdiv(n)
  puts mean
 end




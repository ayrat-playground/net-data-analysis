require_relative 'counter'

success =0

(1..1000).each do
  count =Counter.new(50)
  count.rand_calculate
  success=count.success+success

end

puts success/1000.to_f

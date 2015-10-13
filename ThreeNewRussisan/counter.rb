
class Counter
  def initialize(n)

    @n = n
    @all=0
    @success=0
    @places = Array.new(@n)
    @places=nullify(@places)

  end

  def rand_calculate
    n1=rand(0...@n)
    n2=rand(0...@n)
    while n1==n2
      n2=rand(0...@n)
    end
    n3 = rand(0...@n)
    while n3==n2 || n3==n1
      n3=rand(0...@n)
    end
    @places[n1]=1
    @places[n2]=2
    @places[n3]=3

    rec_rand_calculate(3)

  end

  def rec_rand_calculate(num)
    if(num==@n)
      if @places[@n-1]==@n
        @success=@success+1
      end
      @all=@all+1
      return
    end

    if @places[num]==0
      @places[num]=num+1
      rec_rand_calculate(num+1)

    else
      n = rand(0...@n)
      while (@places[n]!=0)
        n = rand(0...@n)
      end
      @places[n]=num+1
      rec_rand_calculate(num+1)

    end
  end


  def nullify (ar)
    (0..@n-1).each do |i|
      ar[i]=0
    end
    ar
  end

  def all
    @all
  end

  def success
    @success
  end




end
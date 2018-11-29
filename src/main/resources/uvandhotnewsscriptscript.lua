--[[ 判断虑重结果，如果不等于0则表示没有被过滤 ]]
if (redis.call('pfadd',KEYS[1],ARGV[1]) ~= 0)
then
    --[[  将当前头条加入到热点集合中  ]]
    redis.call('zadd',KEYS[2],redis.call('pfcount',KEYS[1]),ARGV[2])
    --[[  判断集合数量是否超过限定的数目  ]]
    if (redis.call('zcard',KEYS[2]) > 10)
    then
        --[[   将点击量最低的头条移除     ]]
        redis.call('zremrangebyrank',KEYS[2], 0, 0)
    end
end
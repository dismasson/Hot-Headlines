--[[ 计算UV的函数 --]]
function uvFunction(uvkey,value,hotkey)
    --[[ 获取当前hll基数数量 --]]
    local uvNow = redis.call('pfcount',uvkey)
    --[[ 获取当前添加后的基数数量 --]]
    local uvNew = redis.call('pfadd',uvkey,value)
    --[[ 如果UV数量增加则调用计算热点头条的函数 --]]
    if(uvNew > uvNow)
        hotNewsFunction(hotkey,uvNew,value)
    end
end
--[[ 计算热点头条的函数 --]]
function hotNewsFunction(key,score,value)
    --[[ 往热点新闻有序集合中添加数据 --]]
    redis.call('zadd',key,score,value)
    --[[ 判断当前添加后再集合中的位置 --]]
    local rank = redis.call('zrank',key,value)
    --[[ 位置从0开始，这里设定热点新闻最大储存10条数据 --]]
    local maxRank = 9
    if(rank > maxRank)
    then
        --[[ 有序集合为正序排列，删除第一个位置的热点新闻 --]]
        redis.call('zremrangebyrank',key,0,0)
    end
end
uvFunction(KEYS[1],ARGV[1],KEYS[2])




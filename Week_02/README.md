学习笔记

1、两数之和题目中，可以先判断缓存中是否包含target - nums[i]，然后再把nums[i]存到缓存中，在达到条件时把2个值的index换一下就可以了，这样整个数组只需要遍历一次就行；
2、小写字符可以使用 ch - 'a'作为下标存在整型数组中
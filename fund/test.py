#!/usr/bin/env python
import re
from math import log10
import numpy

time = []
log_plot = []

def read_number(filename):
	with open(filename, 'r') as f:
		for line in f:
			t = re.findall("\d+.\d+", line)
			if t:
				time.append(t)
				
read_number("./run.txt")

def log_log():
	for pair in time:
		ti = float(pair[1])
		if not ti == 0:
			ti = log10(ti)

			num = float(pair[0])
			num = log10(num)
			log_plot.append([num, ti])

log_log()	

def fitline():
	x, y = zip(*log_plot)
	p = numpy.polyfit(x, y, 1)
	print x
	print y
	print p

fitline()	

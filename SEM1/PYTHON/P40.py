def alternate(s, i=0):
    if i>=len(s):
        return ''
    return s[i]+alternate(s, i+2)

text = 'Hallucination'
print(alternate(text))
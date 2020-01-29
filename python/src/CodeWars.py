def divisible_by(numbers: [], divisor):
    answer = []
    for i in numbers:
        if i % divisor == 0:
            answer.append(i)
    return answer

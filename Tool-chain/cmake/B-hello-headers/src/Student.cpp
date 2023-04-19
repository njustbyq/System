#include <iostream>

#include "Student.h"

void Student::CalculateScore(int &score)
{
    score = m_chinese_score + m_math_score + m_english_score;
}

void Student::show()
{
    int score = 0;
    CalculateScore(score);
    std::cout << m_name << "'s age is " << m_age <<", and the score of total is "<< score << std::endl;
}

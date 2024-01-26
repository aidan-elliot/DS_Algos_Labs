import matplotlib.pyplot as plt
import numpy as np

# Define the starting point, ending point, and instances of points.
x = np.linspace(0, 2000, 500)

# Define base layout size/shape of graph
fig, ax = plt.subplots(figsize=(5, 5), constrained_layout=True)

# Plot each function and label
ax.plot(x, x**(14/16), label='n^(14/16) - Sublinear')
ax.plot(x, x+5, label='(n+5) - Linear')
ax.plot(x, x * np.log(x), label='nlogn(n) - Loglinear')
ax.plot(x, (x+5)**2, label='(n+5)^2 - Quadratic')
ax.plot(x, (x+5)**3, label='(n+5) Cubic')
ax.plot(x, (x+5)**5, label='(n+5) Quintic')

# Set axis labels,
ax.set_xlabel('Input')
ax.set_ylabel('Time Complexity')
ax.set_title("Lab 2 DS&A")
ax.legend()
ax.set_ylim(0, 10000)

# Display graph
plt.show()
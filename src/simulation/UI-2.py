import tkinter as tk

root = tk.Tk()

root.title("Food-Truck")
root.geometry("460x300")  # width x height 

root.columnconfigure(0, weight=1)
root.columnconfigure(1, weight=1)  
root.rowconfigure(0, weight=1)     


#Left frame
left_frame = tk.Frame(root, bg="#222222", highlightbackground="red", highlightthickness=2)

left_frame.grid(row=0, column=0, sticky="nsew", padx=15, pady=15)
left_frame.grid_propagate(False)


#Right frame
right_frame = tk.Frame(root, bg="#222222", highlightbackground="blue", highlightthickness=2)

right_frame.grid(row=0, column=1, sticky="nsew", padx=15, pady=15)
right_frame.grid_propagate(False)







root.mainloop()
